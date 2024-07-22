package net.crossover661.endercompass;

import net.fabricmc.api.ClientModInitializer;
import net.crossover661.endercompass.item.EnderCompassItem;
import net.crossover661.endercompass.item.ModItems;
import net.minecraft.client.item.CompassAnglePredicateProvider;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class EnderCompassClient implements ClientModInitializer {

	@Override
    public void onInitializeClient() {
        ModelPredicateProviderRegistry.register(
			ModItems.ENDER_COMPASS,
			new Identifier("angle"),
			new CompassAnglePredicateProvider(
				(world, stack, entity) -> EnderCompassItem.createStrongholdPos(stack.getOrCreateNbt(), world)
			)
        );
    }
}
