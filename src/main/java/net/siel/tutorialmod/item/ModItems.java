package net.siel.tutorialmod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.siel.tutorialmod.TutorialMod;

public class ModItems {
    // we create a register that will hold all of our items
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    // create a topaz item, with their properties, but we give it none
    public static final DeferredItem<Item> TOPAZ = ITEMS.register("topaz",
            () -> new Item(new Item.Properties()));

    // create a raw version of the item for ores
    public static final DeferredItem<Item> RAW_TOPAZ = ITEMS.register("raw_topaz",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
