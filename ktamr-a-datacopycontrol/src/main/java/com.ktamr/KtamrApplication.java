package com.ktamr;

//import com.sun.jna.Library;
//import com.sun.jna.Native;
//import com.sun.jna.Platform;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.ktamr.mapper")
public class KtamrApplication {
//    public interface testdll extends Library {
//        // msvcrt为dll名称,msvcrt目录的位置为:C:\Windows\System32下面,
//        testdll Instance = (testdll) Native.loadLibrary((Platform.isWindows() ? "Ha_com2.ha_agent.1" : "c"),
//                testdll.class);xxxxx
//        // printf为msvcrt.dll中的一个方法.
//        void ht_cmd_request(String str,Object ... args);
//    }
//    static {
//        System.load("C:\\Windows\\System32\\KERNEL32.DLL");
//        System.load("C:\\Windows\\System32\\USER32.dll");
//        System.load("C:\\Windows\\System32\\ADVAPI32.dll");
//        System.load("C:\\Windows\\System32\\OLE32.dll");
//        System.load("C:\\Windows\\System32\\OLEAUT32.dll");
//        System.load("C:\\Windows\\System32\\SHLWAPI.dll");
//        System.load("E:\\jp\\web_ol\\bin\\msvcr71.dll");
//        System.load("C:\\Windows\\System32\\WS2_32.dll");
//        System.load("E:\\jp\\web_ol\\bin\\HA_COM2.dll");
//    }
//    public native static String ht_cmd_request(String str,String str2);

    public static void main(String args[]){

        //String c = ht_cmd_request("192.168.100.12:12508","ad:sdasdas");

        SpringApplication.run(KtamrApplication.class, args);

        System.out.println("(♥◠‿◠)ﾉﾞ  自动抄表管理系统启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
