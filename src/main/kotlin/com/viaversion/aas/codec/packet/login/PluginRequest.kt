package com.viaversion.aas.codec.packet.login

import com.viaversion.aas.codec.packet.Packet
import com.viaversion.aas.readRemainingBytes
import com.viaversion.viaversion.api.type.Type
import io.netty.buffer.ByteBuf
import kotlin.properties.Delegates

class PluginRequest : Packet {
    var id by Delegates.notNull<Int>()
    lateinit var channel: String
    lateinit var data: ByteArray
    override fun decode(byteBuf: ByteBuf, protocolVersion: Int) {
        id = Type.VAR_INT.readPrimitive(byteBuf)
        channel = Type.STRING.read(byteBuf)
        data = readRemainingBytes(byteBuf)
    }

    override fun encode(byteBuf: ByteBuf, protocolVersion: Int) {
        Type.VAR_INT.writePrimitive(byteBuf, id)
        Type.STRING.write(byteBuf, channel)
        byteBuf.writeBytes(data)
    }
}