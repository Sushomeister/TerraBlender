/**
 * Copyright (C) Glitchfiend
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package terrablender.core;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.level.levelgen.SurfaceRules;
import terrablender.api.GenerationSettings;
import terrablender.api.TerraBlenderApi;
import terrablender.config.TerraBlenderConfig;

import java.util.Optional;

public class TerraBlenderFabric implements ModInitializer
{
    private static final TerraBlenderConfig CONFIG = new TerraBlenderConfig(FabricLoader.getInstance().getConfigDir().resolve(TerraBlender.MOD_ID + ".toml"));

    @Override
    public void onInitialize()
    {
        TerraBlender.setConfig(CONFIG);
        TerraBlender.register();
        CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) -> TerraBlender.registerCommands(dispatcher)));

        FabricLoader.getInstance().getEntrypointContainers("terrablender", TerraBlenderApi.class).forEach(entrypoint -> {
            TerraBlenderApi api = entrypoint.getEntrypoint();
            Optional<SurfaceRules.RuleSource> defaultOverworldSurfaceRules = api.getDefaultOverworldSurfaceRules();
            Optional<SurfaceRules.RuleSource> defaultNetherSurfaceRules = api.getDefaultNetherSurfaceRules();

            if (defaultOverworldSurfaceRules.isPresent()) GenerationSettings.setDefaultOverworldSurfaceRules(defaultOverworldSurfaceRules.get());
            if (defaultNetherSurfaceRules.isPresent()) GenerationSettings.setDefaultNetherSurfaceRules(defaultNetherSurfaceRules.get());
        });

        TerraBlender.registerNoiseGeneratorSettings();
    }
}
