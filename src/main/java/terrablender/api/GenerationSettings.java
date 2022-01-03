/*******************************************************************************
 * Copyright 2022, the Glitchfiend Team.
 * Creative Commons Attribution-NonCommercial-NoDerivatives 4.0.
 ******************************************************************************/
package terrablender.api;

import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class GenerationSettings
{
    private static boolean amplified = false;
    private static boolean largeBiomes = false;
    private static SurfaceRules.RuleSource defaultOverworldSurfaceRules = SurfaceRuleData.overworld();
    private static SurfaceRules.RuleSource defaultNetherSurfaceRules = SurfaceRuleData.nether();

    public static void setAmplified(boolean value)
    {
        amplified = value;
    }

    public static void setLargeBiomes(boolean value)
    {
        largeBiomes = value;
    }

    public static void setDefaultOverworldSurfaceRules(SurfaceRules.RuleSource rules)
    {
        defaultOverworldSurfaceRules = rules;
    }

    public static void setDefaultNetherSurfaceRules(SurfaceRules.RuleSource rules)
    {
        defaultNetherSurfaceRules = rules;
    }

    public static boolean isAmplified()
    {
        return amplified;
    }

    public static boolean isLargeBiomes()
    {
        return largeBiomes;
    }

    public static SurfaceRules.RuleSource getDefaultOverworldSurfaceRules()
    {
        return defaultOverworldSurfaceRules;
    }

    public static SurfaceRules.RuleSource getDefaultNetherSurfaceRules()
    {
        return defaultNetherSurfaceRules;
    }
}