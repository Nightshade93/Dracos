package com.github.dracos.mixin;


        import com.github.dracos.Dracos;
        import net.minecraft.entity.Entity;
        import net.minecraft.entity.LivingEntity;
        import net.minecraft.entity.boss.WitherEntity;
        import net.minecraft.entity.boss.dragon.EnderDragonEntity;
        import net.minecraft.entity.damage.DamageSource;
        import net.minecraft.entity.mob.HostileEntity;
        import net.minecraft.server.network.ServerPlayerEntity;
        import org.spongepowered.asm.mixin.Mixin;
        import org.spongepowered.asm.mixin.injection.At;
        import org.spongepowered.asm.mixin.injection.Inject;
        import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("ConstantConditions")
@Mixin(LivingEntity.class)
public abstract class KillMixin {
    @Inject(at = @At("HEAD"), method = "onDeath")
    private void onKilledXPTracker(DamageSource source, CallbackInfo info) {
        LivingEntity le = (LivingEntity) (Object) this;
        if (!le.world.isClient && !le.removed) {
            Entity entity = source.getAttacker();
            if (entity instanceof ServerPlayerEntity) {
                ServerPlayerEntity serverPlayer = (ServerPlayerEntity) entity;
                if (le instanceof WitherEntity || le instanceof EnderDragonEntity) {
                    Dracos.addXpAndLevelUp(Dracos.PLAYER_LEVEL, serverPlayer, 130);
                } else if (le instanceof HostileEntity) {
                    Dracos.addXpAndLevelUp(Dracos.PLAYER_LEVEL, serverPlayer, Dracos.calculateXpGiven(Dracos.checkPlayerLevel(Dracos.PLAYER_LEVEL, serverPlayer)));
                }
            }
        }
    }

}