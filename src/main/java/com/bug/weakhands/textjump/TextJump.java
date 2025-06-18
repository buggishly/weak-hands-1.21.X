package com.bug.weakhands.textjump;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class TextJump implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(literal("jump").executes(context -> {
            ClientPlayerEntity player = net.minecraft.client.MinecraftClient.getInstance().player;
            if (player != null) {
                Vec3d vel = player.getVelocity();
                player.setVelocity(vel.x, 0.5, vel.z);
                player.sendMessage(Text.literal("Client-jump!"), false);
            }
            return 1;
        })));
    }
}