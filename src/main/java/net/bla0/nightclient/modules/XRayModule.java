package net.bla0.nightclient.modules;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.HashSet;
import java.util.Set;

public class XRayModule extends Module {

    private static final Set<Block> xrayBlocks = new HashSet();

    public Module init() {
        xrayBlocks.add(Blocks.COAL_BLOCK);
        xrayBlocks.add(Blocks.COPPER_ORE);
        xrayBlocks.add(Blocks.IRON_ORE);
        xrayBlocks.add(Blocks.GOLD_ORE);
        xrayBlocks.add(Blocks.DIAMOND_ORE);
        xrayBlocks.add(Blocks.EMERALD_ORE);
        xrayBlocks.add(Blocks.LAPIS_ORE);
        xrayBlocks.add(Blocks.REDSTONE_ORE);
        xrayBlocks.add(Blocks.DEEPSLATE_COAL_ORE);
        xrayBlocks.add(Blocks.DEEPSLATE_COPPER_ORE);
        xrayBlocks.add(Blocks.DEEPSLATE_IRON_ORE);
        xrayBlocks.add(Blocks.DEEPSLATE_GOLD_ORE);
        xrayBlocks.add(Blocks.DEEPSLATE_DIAMOND_ORE);
        xrayBlocks.add(Blocks.DEEPSLATE_EMERALD_ORE);
        xrayBlocks.add(Blocks.DEEPSLATE_LAPIS_ORE);
        xrayBlocks.add(Blocks.DEEPSLATE_REDSTONE_ORE);
        xrayBlocks.add(Blocks.CHEST);
        xrayBlocks.add(Blocks.SPAWNER);
        xrayBlocks.add(Blocks.BOOKSHELF);
        xrayBlocks.add(Blocks.ANCIENT_DEBRIS);
        xrayBlocks.add(Blocks.NETHER_GOLD_ORE);
        xrayBlocks.add(Blocks.NETHER_QUARTZ_ORE);
        xrayBlocks.add(Blocks.GLOWSTONE);
        xrayBlocks.add(Blocks.LAVA);
        xrayBlocks.add(Blocks.WATER);
        xrayBlocks.add(Blocks.CRAFTING_TABLE);
        xrayBlocks.add(Blocks.FURNACE);
        return this;
    }
    protected XRayModule() {
        super("Xray", "Let's you see through the ground, useful for mining", ModuleType.TEST);
    }

    @Override
    public void onEnable() {
        //MinecraftClient.getInstance().player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, Integer.MAX_VALUE));
        MinecraftClient.getInstance().worldRenderer.reload();
    }

    @Override
    public void onDisable() {
        //MinecraftClient.getInstance().player.removeStatusEffect(StatusEffects.NIGHT_VISION);
        MinecraftClient.getInstance().worldRenderer.reload();
    }

    @Override
    public void onTick() {

    }

    @Override
    public void onBackgroundTick() {

    }

    @Override
    public void onWorldRender(MatrixStack stack) {

    }

    @Override
    public void onHudRender(MatrixStack stack) {

    }

    public static boolean showBlock(BlockState state, BlockView world, BlockPos pos) {
        return xrayBlocks.contains(state.getBlock()) && !state.getBlock().isTransparent(state, world, pos);
    }
}
