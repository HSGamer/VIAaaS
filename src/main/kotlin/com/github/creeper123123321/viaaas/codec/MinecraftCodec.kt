package com.github.creeper123123321.viaaas.codec

import com.github.creeper123123321.viaaas.handler.MinecraftHandler
import com.github.creeper123123321.viaaas.packet.Packet
import com.github.creeper123123321.viaaas.packet.PacketRegistry
import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufAllocator
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageCodec
import us.myles.ViaVersion.exception.CancelEncoderException

class MinecraftCodec : MessageToMessageCodec<ByteBuf, Packet>() {
    override fun encode(ctx: ChannelHandlerContext, msg: Packet, out: MutableList<Any>) {
        if (!ctx.channel().isActive) throw CancelEncoderException.CACHED
        val buf = ByteBufAllocator.DEFAULT.buffer()
        try {
            val handler = ctx.pipeline().get(MinecraftHandler::class.java)
            PacketRegistry.encode(msg, buf, handler.data.frontVer!!, serverBound = !handler.frontEnd)
            out.add(buf.retain())
        } finally {
            buf.release()
        }
    }

    override fun decode(ctx: ChannelHandlerContext, msg: ByteBuf, out: MutableList<Any>) {
        if (!ctx.channel().isActive || !msg.isReadable) return
        val handler = ctx.pipeline().get(MinecraftHandler::class.java)
        out.add(
            PacketRegistry.decode(
                msg,
                handler.data.frontVer ?: 0,
                handler.data.state.state, handler.frontEnd
            )
        )
        if (msg.isReadable) throw IllegalStateException("Remaining bytes!!!")
    }
}