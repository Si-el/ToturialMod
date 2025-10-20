package net.siel.tutorialmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.siel.tutorialmod.TutorialMod;
import net.siel.tutorialmod.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    // we create our registry of mode tabs for creative mode
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    // this is where we create the tabs, here we make the following:
    // a tab for all items, the icon being an item of our choice, the title where we give a key, the items we wish to display.
    public static final Supplier<CreativeModeTab> TUTORIALMOD_ITEM_TAB = CREATIVE_MODE_TAB.register("tutorialmod_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(()-> new ItemStack(ModItems.TOPAZ.get()))
                    .title(Component.translatable("creativetab.tutorialmod.tutorialmod_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TOPAZ);
                        output.accept(ModItems.RAW_TOPAZ);
                    }).build());

        public static final Supplier<CreativeModeTab> TUTORIALMOD_BLOCK_TAB = CREATIVE_MODE_TAB.register("tutorialmod_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(()-> new ItemStack(ModBlocks.TOPAZ_BLOCK.get()))
                    // here we make it appear AFTER the items tab
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "tutorialmod_items_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.tutorialmod_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.TOPAZ_BLOCK);
                        output.accept(ModBlocks.TOPAZ_ORE);
                        output.accept(ModBlocks.TOPAZ_DEEPSLATE_ORE);
                    }).build());

    // we create here our register ofc, always needed when wanting to add smth to the game
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
