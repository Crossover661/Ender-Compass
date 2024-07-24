package net.crossover661.endercompass.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.registry.tag.StructureTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;

public class EnderCompassItem extends Item {
    
    public EnderCompassItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (world instanceof ServerWorld serverWorld) {
            BlockPos blockPos = serverWorld.locateStructure(StructureTags.EYE_OF_ENDER_LOCATED, entity.getBlockPos(), 500, false);
            if (blockPos != null) {
                NbtCompound nbt = stack.getOrCreateNbt();
                nbt.put("Pos", NbtHelper.fromBlockPos(blockPos));
            }
        }
    }

    public static GlobalPos createStrongholdPos(NbtCompound nbt, World world) {
        if (world.getDimension().natural() && nbt.contains("Pos")) {
            BlockPos blockPos = NbtHelper.toBlockPos(nbt.getCompound("Pos"));
            if (blockPos != null) {return GlobalPos.create(world.getRegistryKey(), blockPos);}
            else {return null;}
        }
        else {return null;}
    }
}
