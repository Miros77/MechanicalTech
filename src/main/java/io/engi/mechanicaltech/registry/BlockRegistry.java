package io.engi.mechanicaltech.registry;

import com.google.common.collect.ImmutableSet;
import io.engi.fabricmc.lib.util.RelativeDirection;
import io.engi.mechanicaltech.MechanicalTech;
import io.engi.mechanicaltech.block.*;
import net.minecraft.block.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static io.engi.mechanicaltech.MechanicalTech.MODID;

public class BlockRegistry {
	// POWER SUPPLIERS
	public static TurbineBlock TURBINE = new TurbineBlock(Block.Settings.copy(Blocks.IRON_BLOCK), 1);
	public static WindsailBlock WINDSAIL = new WindsailBlock(Block.Settings.copy(Blocks.WHITE_WOOL), 1);
	public static WaterwheelBlock WATERWHEEL = new WaterwheelBlock(Block.Settings.copy(Blocks.OAK_PLANKS), 1);
	public static ManualCrankBlock MANUAL_CRANK = new ManualCrankBlock(Block.Settings.copy(Blocks.OAK_FENCE), 5);

	// POWER RECEIVERS
	public static MillBlock MILL = new MillBlock(Block.Settings.copy(Blocks.DISPENSER));

	// POWER CONDUCTORS
	public static Block CROSS_CONNECTOR = new CrossConnectorBlock(Block.Settings.copy(Blocks.DISPENSER), ImmutableSet.of(MechanicalTech.PAYLOAD_ENERGY));
	public static Block ANGLED_CONNECTOR_RIGHT = new AngledConnectorBlock(
		Block.Settings.copy(Blocks.DISPENSER),
		RelativeDirection.RIGHT,
		ImmutableSet.of(MechanicalTech.PAYLOAD_ENERGY)
	);
	public static Block ANGLED_CONNECTOR_LEFT = new AngledConnectorBlock(
		Block.Settings.copy(Blocks.DISPENSER),
		RelativeDirection.LEFT,
		ImmutableSet.of(MechanicalTech.PAYLOAD_ENERGY)
	);
	public static Block ANGLED_CONNECTOR_UP = new AngledConnectorBlock(
		Block.Settings.copy(Blocks.DISPENSER),
		RelativeDirection.UP,
		ImmutableSet.of(MechanicalTech.PAYLOAD_ENERGY)
	);
	public static Block ANGLED_CONNECTOR_DOWN = new AngledConnectorBlock(
		Block.Settings.copy(Blocks.DISPENSER),
		RelativeDirection.DOWN,
		ImmutableSet.of(MechanicalTech.PAYLOAD_ENERGY)
	);
	public static Block ANGLED_CONNECTOR_FORWARD_BELOW = new AngledConnectorBlock(
		Block.Settings.copy(Blocks.DISPENSER),
		RelativeDirection.DOWN,
		RelativeDirection.FRONT,
		ImmutableSet.of(MechanicalTech.PAYLOAD_ENERGY)
	);
	public static Block ANGLED_CONNECTOR_FORWARD_ABOVE = new AngledConnectorBlock(
		Block.Settings.copy(Blocks.DISPENSER),
		RelativeDirection.UP,
		RelativeDirection.FRONT,
		ImmutableSet.of(MechanicalTech.PAYLOAD_ENERGY)
	);
	public static Block SPINDLE = new SpindleBlock(Block.Settings.copy(Blocks.COBBLESTONE_WALL));

	public static void initialize() {
		Registry.register(Registry.BLOCK, new Identifier(MODID, "turbine"), TURBINE);
		Registry.register(Registry.BLOCK, new Identifier(MODID, "windsail"), WINDSAIL);
		Registry.register(Registry.BLOCK, new Identifier(MODID, "waterwheel"), WATERWHEEL);
		Registry.register(Registry.BLOCK, new Identifier(MODID, "manual_crank"), MANUAL_CRANK);

		Registry.register(Registry.BLOCK, new Identifier(MODID, "mill"), MILL);

		Registry.register(Registry.BLOCK, new Identifier(MODID, "cross_connector"), CROSS_CONNECTOR);
		Registry.register(Registry.BLOCK, new Identifier(MODID, "angled_connector_right"), ANGLED_CONNECTOR_RIGHT);
		Registry.register(Registry.BLOCK, new Identifier(MODID, "angled_connector_left"), ANGLED_CONNECTOR_LEFT);
		Registry.register(Registry.BLOCK, new Identifier(MODID, "angled_connector_up"), ANGLED_CONNECTOR_UP);
		Registry.register(Registry.BLOCK, new Identifier(MODID, "angled_connector_down"), ANGLED_CONNECTOR_DOWN);
		Registry.register(Registry.BLOCK, new Identifier(MODID, "angled_connector_forward_below"), ANGLED_CONNECTOR_FORWARD_BELOW);
		Registry.register(Registry.BLOCK, new Identifier(MODID, "angled_connector_forward_above"), ANGLED_CONNECTOR_FORWARD_ABOVE);
		Registry.register(Registry.BLOCK, new Identifier(MODID, "spindle"), SPINDLE);
	}
}
