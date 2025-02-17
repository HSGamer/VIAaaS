/*
 * Copyright (c) RK_01  2021.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT
 * OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * ===================================
 *
 * Copyright (c) VIAaaS contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.viaversion.aas.protocol.sharewareto1_14;

import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;

public enum ServerboundPacketsShareware implements ServerboundPacketType {

	TELEPORT_CONFIRM, // 0x00
	QUERY_BLOCK_NBT, // 0x01
	SET_DIFFICULTY, // 0x02
	CHAT_MESSAGE, // 0x03
	CLIENT_STATUS, // 0x04
	CLIENT_SETTINGS, // 0x05
	TAB_COMPLETE, // 0x06
	WINDOW_CONFIRMATION, // 0x07
	CLICK_WINDOW_BUTTON, // 0x08
	CLICK_WINDOW, // 0x09
	CLOSE_WINDOW, // 0x0A
	PLUGIN_MESSAGE, // 0x0B
	EDIT_BOOK, // 0x0C
	ENTITY_NBT_REQUEST, // 0x0D
	INTERACT_ENTITY, // 0x0E
	LOCK_DIFFICULTY, // 0x0F
	KEEP_ALIVE, // 0x10
	PLAYER_MOVEMENT, // 0x11
	PLAYER_POSITION, // 0x12
	PLAYER_POSITION_AND_ROTATION, // 0x13
	PLAYER_ROTATION, // 0x14
	VEHICLE_MOVE, // 0x15
	STEER_BOAT, // 0x16
	PICK_ITEM, // 0x17
	CRAFT_RECIPE_REQUEST, // 0x18
	PLAYER_ABILITIES, // 0x19
	PLAYER_DIGGING, // 0x1A
	ENTITY_ACTION, // 0x1B
	STEER_VEHICLE, // 0x1C
	RECIPE_BOOK_DATA, // 0x1D
	RENAME_ITEM, // 0x1E
	RESOURCE_PACK_STATUS, // 0x1F
	ADVANCEMENT_TAB, // 0x20
	SELECT_TRADE, // 0x21
	SET_BEACON_EFFECT, // 0x22
	HELD_ITEM_CHANGE, // 0x23
	UPDATE_COMMAND_BLOCK, // 0x24
	UPDATE_COMMAND_BLOCK_MINECART, // 0x25
	CREATIVE_INVENTORY_ACTION, // 0x26
	UPDATE_JIGSAW_BLOCK, // 0x27
	UPDATE_STRUCTURE_BLOCK, // 0x28
	UPDATE_SIGN, // 0x29
	ANIMATION, // 0x2A
	SPECTATE, // 0x2B
	PLAYER_BLOCK_PLACEMENT, // 0x2C
	USE_ITEM; // 0x2D

	@Override
	public int getId() {
		return ordinal();
	}

	@Override
	public String getName() {
		return name();
	}
}