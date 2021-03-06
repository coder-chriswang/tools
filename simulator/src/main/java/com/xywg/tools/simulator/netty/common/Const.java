package com.xywg.tools.simulator.netty.common;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPromise;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author : wangyifei
 * Description
 * Date: Created in 13:34 2019/2/20
 * Modified By : wangyifei
 */
public class Const {

    public static final String clientId = "client";

    /**
     * 绑定通道
     */
    public static final AttributeKey<XySession> NETTY_CHANNEL_KEY = AttributeKey.valueOf("netty.channel");


    /**
     * 客户端通道
     * key = clientId
     */
    public static Map<String, Channel> clientChannels = new ConcurrentHashMap<>();


    public static void send(Channel channel,String data){
        ByteBuf byteBuf= Unpooled.buffer(data.length());
        byteBuf.writeBytes(data.getBytes());
        channel.writeAndFlush(byteBuf);
    }
    public static void send (String clientId ,String data){
        ByteBuf byteBuf= Unpooled.buffer(data.length());
        byteBuf.writeBytes(data.getBytes());
        clientChannels.get(clientId).writeAndFlush(byteBuf);
    }


}
