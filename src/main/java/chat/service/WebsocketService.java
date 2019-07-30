package chat.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.ImmediateEventExecutor;
import org.omg.PortableInterceptor.Interceptor;

public class WebsocketService {

    private final NioEventLoopGroup bossGroup = new NioEventLoopGroup();

    private final NioEventLoopGroup workerGroup = new NioEventLoopGroup();

    private final ChannelGroup defaultChannelGroup = new DefaultChannelGroup(ImmediateEventExecutor.INSTANCE);

    public void start() {

        // 这里开启下相应的
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new WebsocketInitializer(defaultChannelGroup));


    }
}
