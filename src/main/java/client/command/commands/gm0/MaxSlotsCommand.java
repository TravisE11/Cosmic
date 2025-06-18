/*
    This file is part of the HeavenMS MapleStory Server, commands OdinMS-based
    Copyleft (L) 2016 - 2019 RonanLana

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation version 3 as published by
    the Free Software Foundation. You may not use, modify or distribute
    this program under any other version of the GNU Affero General Public
    License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

/*
   @Author: Arthur L - Refactored command content into modules
*/
package client.command.commands.gm0;

import client.Character;
import client.Client;
import client.command.Command;
import client.inventory.InventoryType;
import config.YamlConfig;

public class MaxSlotsCommand extends Command {
    {
        setDescription("Increase the slot count up to 96.");
    }

    @Override
    public void execute(Client c, String[] params) {

        for (int i = 1; i < 24; i++) {
            Character player = c.getPlayer();
            for (byte slotType = 1; slotType < 5; slotType++) {
                player.gainSlots(slotType, 4, true);
            }
        }
    }
}
