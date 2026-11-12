package org.architectum_workshop.archeologic_caverns.common.util.functionalI;

import net.minecraft.world.phys.shapes.VoxelShape;

@FunctionalInterface
public interface ToShapeInterface<T> {
    VoxelShape toShape(T state);
}
