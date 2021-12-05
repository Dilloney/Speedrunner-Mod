package net.dilloney.speedrunnermod.client.timer.data;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class SingleRun extends AbstractRun {
    public long ticks;
    public long startTimestamp;

    public SingleRun(long ticks) {
        this.ticks = ticks;
        startTimestamp = System.currentTimeMillis();
    }

    public long getGameTime() {
        return ticks * 50;
    }

    public long getRealTimeDuration() {
        return System.currentTimeMillis() - startTimestamp;
    }
}