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
import client.inventory.manipulator.InventoryManipulator;
import server.ItemInformationProvider;
import server.Shop;
import client.command.Command;
import client.inventory.Equip;
import client.inventory.Inventory;
import client.inventory.InventoryType;
import client.inventory.Item;

public class SellCommand extends Command {
    {
        setDescription("Increase the slot count up to 96.");
    }

    @Override
    public void execute(Client c, String[] params) {

        Character player = c.getPlayer();
        Inventory equip = player.getInventory(InventoryType.EQUIP);
        for (byte i = 1; i <= equip.getSlotLimit(); i++) {

            Item item = c.getPlayer().getInventory(InventoryType.EQUIP).getItem(i);

            if (item != null) {
                ItemInformationProvider ii = ItemInformationProvider.getInstance();
                int mesos = ii.getPrice(item.getItemId(), 1);
                if (mesos > 0) {
                    c.getPlayer().gainMeso(mesos, false);
                }
                InventoryManipulator.removeFromSlot(c, InventoryType.EQUIP, (short) i, (short) 1, false);
            }
        }
    }
}