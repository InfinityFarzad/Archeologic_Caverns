package org.architectum_workshop.archeologic_caverns.common.util;

import net.minecraft.world.phys.shapes.VoxelShape;

@FunctionalInterface
public interface ToShapeInterface<T> {
    VoxelShape toShape(T state);
}
