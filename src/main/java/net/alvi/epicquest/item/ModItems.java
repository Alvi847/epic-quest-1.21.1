package net.alvi.epicquest.item;

import net.alvi.epicquest.EpicQuest;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import javax.xml.crypto.Data;
import java.util.List;

public class ModItems {
    public static final Item RED_PEARL = registerItem("red_pearl", new Item(new Item.Settings()
            .component(DataComponentTypes.RARITY, Rarity.EPIC)) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip." + EpicQuest.MOD_ID + ".red_pearl.line1")
                            .formatted(Formatting.GOLD)
                            .styled(style -> style.withItalic(false))
                            .styled(style -> style.withBold(true)));
                    tooltip.add(Text.translatable("tooltip." + EpicQuest.MOD_ID + ".red_pearl.line2")
                            .formatted(Formatting.GRAY)
                            .styled(style -> style.withItalic(false)));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });

    public static final Item GEM_SWORD = registerItem("gem_sword",
            new SwordItem(ModToolMaterials.GEM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.GEM, 3, -2.4f))
                    .rarity(Rarity.EPIC)) {
                @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip." + EpicQuest.MOD_ID + ".gem_sword.line1")
                            .formatted(Formatting.GOLD)
                            .styled(style -> style.withItalic(false))
                            .styled(style -> style.withBold(true)));
                    if(!Screen.hasShiftDown()){
                        tooltip.add(Text.translatable("tooltip." + EpicQuest.MOD_ID + ".gem_sword.shift"));
                    }
                    else {
                        tooltip.add(Text.translatable("tooltip." + EpicQuest.MOD_ID + ".gem_sword.line2")
                                .formatted(Formatting.GRAY)
                                .styled(style -> style.withItalic(false)));
                    }
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(EpicQuest.MOD_ID, name), item);
    }

    public static void registerModItems(){
        EpicQuest.LOGGER.info("Registering Mod Items for " + EpicQuest.MOD_ID);

        /*ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RED_PEARL);
        });*/
    }
}
