package com.learningtomod.myfirstmod;

import com.google.common.collect.Lists;
import com.google.common.reflect.ClassPath;
import com.learningtomod.myfirstmod.internal.content.ItemContent;
import com.learningtomod.myfirstmod.internal.content.BlockContent;
import com.learningtomod.myfirstmod.internal.content.BlockMethods;
import com.learningtomod.myfirstmod.internal.content.ItemBlockContent;
import com.learningtomod.myfirstmod.internal.content.ItemMethods;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Mod(
        modid = MyFirstMod.MOD_ID,
        name = MyFirstMod.MOD_NAME,
        version = MyFirstMod.VERSION
)
public class MyFirstMod {

    public static final String MOD_ID = "myfirstmod";
    public static final String MOD_NAME = "MyFirstMod";
    public static final String VERSION = "1.0.0";

    public static Logger LOGGER;
    public static final CreativeTabs CREATIVE_TABS = new CreativeTabs("myfirstmod") {
        @Override
        @Nonnull
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.DIAMOND);
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER = event.getModLog();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @EventBusSubscriber
    public static class RegistryHandler {
        public static List<BlockContent> blockList = Lists.newArrayList();
        public static List<ItemBlockContent> itemBlockContentList = Lists.newArrayList();
        public static List<Item> itemList = Lists.newArrayList();

        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
            itemBlockContentList.addAll(blockList.stream()
                    .map(ItemBlockContent::new)
                    .collect(Collectors.toList()));
            itemBlockContentList.forEach(event.getRegistry()::register);

            itemList.addAll(getObjects("com.learningtomod.myfirstmod.content.items")
                    .stream()
                    .filter(objectInstance -> objectInstance instanceof ItemMethods)
                    .map(objectInstance -> (ItemMethods) objectInstance)
                    .map(ItemContent::new)
                    .collect(Collectors.toList()));
            itemList.forEach(event.getRegistry()::register);
        }

        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {
            blockList.addAll(getObjects("com.learningtomod.myfirstmod.content.blocks")
                    .stream()
                    .filter(objectInstance -> objectInstance instanceof BlockMethods)
                    .map(objectInstance -> (BlockMethods) objectInstance)
                    .map(BlockContent::new)
                    .collect(Collectors.toList()));
            event.getRegistry().registerAll(blockList.toArray(new Block[0]));
        }

        @SubscribeEvent
        @SideOnly(Side.CLIENT)
        public static void models(ModelRegistryEvent event) {
            blockList.forEach(blockContent -> ModelLoader.setCustomStateMapper(blockContent, new StateMapperBase() {
                @Override
                @Nonnull
                protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
                    return new ModelResourceLocation(new ResourceLocation(MOD_ID, "blockcontent"), "normal");
                }
            }));
            itemBlockContentList.forEach(itemBlockContent -> ModelLoader.setCustomModelResourceLocation(itemBlockContent, 0,
                    new ModelResourceLocation(new ResourceLocation(MOD_ID, "blockcontent"), "normal")));

            itemList.forEach(item -> ModelLoader.setCustomModelResourceLocation(item, 0,
                    new ModelResourceLocation(new ResourceLocation("minecraft", "stick"), "inventory")));
        }
    }

    private static List<Object> getObjects(String packageName) {
        try {
            return ClassPath.from(MyFirstMod.class.getClassLoader())
                    .getTopLevelClasses(packageName).stream()
                    .map(ClassPath.ClassInfo::load)
                    .map(aClass -> {
                        try {
                            return aClass.getDeclaredConstructor();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                        return null;
                    })
                    .filter(Objects::nonNull)
                    .map(constructor -> {
                        try {
                            return constructor.newInstance();
                        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }).collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return Lists.newArrayList();
    }
}
