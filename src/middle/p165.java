package middle;

public class p165 {
    public int compareVersion(String version1, String version2) {
        int p1 = 0, p2 = 0;
        while(p1 < version1.length() || p2 < version2.length()){
            int n1 = 0, n2 = 0;
            while(p1 < version1.length() && version1.charAt(p1) != '.')
                n1 = (version1.charAt(p1++) - '0') + n1 * 10;

            while(p2 < version2.length() && version2.charAt(p2) != '.')
                n2 = (version2.charAt(p2++) - '0') + n2 * 10;

            if(n1 > n2)
                return 1;
            if(n1 < n2)
                return -1;
            p1 ++; p2 ++;

        }
        return 0;
    }


//    public int compareVersion(String version1, String version2) {
//        String[] v1 = version1.split("\\.");
//        String[] v2 = version2.split("\\.");
//
//        int len = v1.length > v2.length ? v1.length : v2.length;
//        for(int i = 0; i < len;i ++){
//            int n1 = i < v1.length ? Integer.parseInt(v1[i]) : 0, n2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
//            System.out.println(n1 +" " +n2);
//            if(n1 < n2)
//                return -1;
//            if(n1 > n2)
//                return 1;
//        }
//        return 0;
//    }


//    public int compareVersion(String version1, String version2) {
//        int point1 = 0, point2 = 0;
//
//        while(point1 < version1.length() || point2 < version2.length()){

//            String temp1 = "", temp2 = "";
//            int now1 = 0, now2 = 0;
//            boolean mark = false;

//                    while(point2 < version2.length() && version2.charAt(point2) != '.')
//                        temp2 = temp2 + version2.charAt(point2 ++);
//                    break;


//                    while(point1 < version1.length() && version1.charAt(point1) != '.')
//                        temp1 = temp1 + version1.charAt(point1 ++);

//            for(int i = 0;i < temp1.length();i ++){
//                if(temp1.charAt(i) != '0') {
//                    now1 = Integer.parseInt(temp1.substring(i));
//                    break;
//                }
//            }
//            for(int i = 0;i < temp2.length();i ++){
//                if(temp2.charAt(i) != '0') {
//                    now2 = Integer.parseInt(temp2.substring(i));
//                    break;
//                }
//            }
//            point1 ++;point2 ++;
//            if(now1 > now2)
//                return 1;
//            if(now1 < now2)
//                return -1;
////            System.out.println(point1 + " " + point2);
////            System.out.println(now1 + " " + now2);
//        }
//        return 0;
//    }
}
