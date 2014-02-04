/* This file is part of VeinMiner.
 *
 *    VeinMiner is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Lesser General Public License as
 *    published by the Free Software Foundation, either version 3 of
 *     the License, or (at your option) any later version.
 *
 *    VeinMiner is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public
 *    License along with VeinMiner.
 *    If not, see <http://www.gnu.org/licenses/>.
 */

package portablejim.veinminer.api;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.Event;
import portablejim.veinminer.VeinMiner;

/**
 * Event to check if Veinmine-ing should start, even though tryHarvestBlock returned false.
 * allowVeinminer == Permission.FORCE_ALLOW || allowVeinMiner.ALLOW: Allow Veinminer to start.
 * allowVeinminer == Permission.FORCE_DENY || allowVeinMiner.DENY: Don't allow Veinminer to start.
 */

public class VeinminerStartCheck extends Event {
    public Permission allowVeinminerStart;
    public final EntityPlayerMP player;
    public final int blockId;
    public final int blockMetadata;
    public final int radiusLimitConfig;
    public final int blockLimitConfig;
    public int radiusLimit;
    public int blockLimit;

    public VeinminerStartCheck(EntityPlayerMP player, int id, int metadata, int radiusLimit, int blockLimit) {
        allowVeinminerStart = Permission.DENY;
        this.player = player;
        this.blockId = id;
        this.blockMetadata = metadata;

        this.radiusLimitConfig = VeinMiner.instance.configurationSettings.getRadiusLimit();
        this.blockLimitConfig = VeinMiner.instance.configurationSettings.getBlockLimit();
        this.radiusLimit = radiusLimit;
        this.blockLimit = blockLimit;
    }
}
