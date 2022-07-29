package other;

public class fourteen {
    public static void main(String[] args){
        String[] strs = {"flower","flow","floight"};
        int i = 0;
        char mark;
        String s = "";
        while(true){
            if(i < strs[0].length()){
                mark = strs[0].charAt(i);
                for(int j = 1;j < strs.length;j ++){
                    if(i < strs[j].length()){
                        if(mark != strs[j].charAt(i)){
                            s = strs[0].substring(0, i);
                            System.out.println(s);
                        }
                    }else{
                        s = strs[j].substring(0, i);
                        System.out.println(s);
                    }
                }
            }else{
                s = strs[0].substring(0, i);
                System.out.println(s);
            }
            i ++;
        }
    }
}
