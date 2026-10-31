package org.architectum_workshop.archeologic_caverns.common.worldgen;

import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class ACTerraBlenderInit implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new CaveRegions(2));
    }
}
