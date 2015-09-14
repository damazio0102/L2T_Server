/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package l2server.gameserver.network.serverpackets;

import l2server.gameserver.instancemanager.CastleManager;
import l2server.gameserver.model.entity.Castle;

/**
 * Format : (h) d [dS]
 * h  sub id
 *
 * d: number of manors
 * [
 * d: id
 * S: manor name
 * ]
 * @author l3x
 *
 */
public class ExSendManorList extends L2GameServerPacket
{
	private static final String _S__FE_1B_EXSENDMANORLIST = "[S] FE:22 ExSendManorList";
	
	@Override
	protected void writeImpl()
	{
		writeC(0xFE);
		writeH(0x22);
		writeD(CastleManager.getInstance().getCastles().size());
		for (Castle castle : CastleManager.getInstance().getCastles())
			writeD(castle.getCastleId());
	}
	
	@Override
	public String getType()
	{
		return _S__FE_1B_EXSENDMANORLIST;
	}
}