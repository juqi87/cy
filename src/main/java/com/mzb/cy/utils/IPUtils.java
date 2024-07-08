package com.mzb.cy.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.List;

public class IPUtils {

    /**
     * 尝试获取当前服务器的IP地址（非公网IP，可能是局域网IP）
     * @return IP地址列表，如果没有找到则返回空列表
     */
    public static List<String> getServerIPs() {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface networkInterface : interfaces) {
                List<InetAddress> addresses = Collections.list(networkInterface.getInetAddresses());
                for (InetAddress address : addresses) {
                    // 忽略回环地址
                    if (!address.isLoopbackAddress()) {
                        // 对于IPv4地址，我们将其添加到列表中
                        // 如果需要包含IPv6地址，可以添加相应的条件
                        String sAddr = address.getHostAddress();
                        // 这里简单处理，直接返回找到的第一个非回环地址
                        // 如果需要返回所有非回环地址，可以修改此处的逻辑
                        return Collections.singletonList(sAddr);
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        // 如果没有找到任何非回环地址，返回空列表
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        List<String> ips = getServerIPs();
        if (!ips.isEmpty()) {
            System.out.println("服务器IP地址：" + ips.get(0));
        } else {
            System.out.println("未找到服务器IP地址");
        }
    }
}
