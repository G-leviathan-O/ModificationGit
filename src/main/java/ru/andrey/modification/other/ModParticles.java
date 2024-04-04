package ru.andrey.modification.other;

import net.minecraft.particle.AbstractDustParticleEffect;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

public class ModParticles {
    public static class ModDustParticleEffect extends AbstractDustParticleEffect {

        public static final DustParticleEffect GREEN = new DustParticleEffect(Vec3d.unpackRgb(0x32CD32).toVector3f(), 1.0f);

        public ModDustParticleEffect(Vector3f vector3f, float f) { super(vector3f, f); }

        public ParticleType<DustParticleEffect> getType() {
            return ParticleTypes.DUST;
        }
    }
}