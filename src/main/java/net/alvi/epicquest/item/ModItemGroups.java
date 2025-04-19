package net.alvi.epicquest.item;

import net.alvi.epicquest.EpicQuest;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup EPICQUEST_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(EpicQuest.MOD_ID, "epicquest_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RED_PEARL))
                    .displayName(Text.translatable("itemgroup.epicquest.epicquest_items"))
                    .entries((displayContext, entries) -> {
                        EpicQuest.LOGGER.info("Registering Item Groups for " + EpicQuest.MOD_ID);
                        entries.add(ModItems.RED_PEARL);
                        entries.add(ModItems.GEM_SWORD);
                    }).build());


    public static void registerItemGroups(){
        //EpicQuest.LOGGER.info("Registering Item Groups for " + EpicQuest.MOD_ID);
    }
}
