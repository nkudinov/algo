package lc.june2020;





public class q16 {
    public static boolean isIPv4LiteralAddress(String ip){
        try {
            if ( ip == null || ip.isEmpty() ) {
                return false;
            }

            String[] parts = ip.split( "\\." );
            if ( parts.length != 4 ) {
                return false;
            }

            for ( String s : parts ) {
                int i = Integer.parseInt( s );
                if ( (i < 0) || (i > 255) ) {
                    return false;
                }
            }
            if ( ip.endsWith(".") ) {
                return false;
            }

            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    public static boolean isIPv6LiteralAddress(String IP){
       return false;
    }
    public static  String validIPAddress(String IP) {
        if (isIPv4LiteralAddress(IP)) {
            return "IPv4";
        }
        if (isIPv6LiteralAddress(IP)) {
            return "IPv6";
        }
        return "This is neither a IPv4 address nor a IPv6 address";
    }
    public static void main(String[] args) {
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }
}
