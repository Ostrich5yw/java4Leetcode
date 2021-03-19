package simple;


public class p125 {
    public static void main(String[] args) {
        p125 t = new p125();
        System.out.println(t.isPalindrome("Marge, let's \"[went].\" I await {news} telegram."));
    }
    public boolean isPalindrome(String s) {
        int head = 0, tail = s.length() - 1;
        while (head < tail){
            char h = s.charAt(head);
            char t = s.charAt(tail);
            h = Character.toLowerCase(h);       //换算为小写，注意如果是0，则不会变化
            t = Character.toLowerCase(t);
            /**
             * 跳过其他多余标点和空格
             * **/
            while((h < '0' || h > '9') && (h < 'a' || h > 'z') && head < s.length() - 1) h = Character.toLowerCase(s.charAt(++head));
            while((t < '0' || t > '9') && (t < 'a' || t > 'z') && tail > 0) t = Character.toLowerCase(s.charAt(--tail));
//            System.out.println(h + " " + t);
            if(h != t)
                if(((h >= '0' && h <= '9') || (h >= 'a' && h <= 'z')) &&            //这里要看最后是否是两个字符，如果是",." 则不会返回false
                        ((t >= '0' && t <= '9') || (t >= 'a' && t <= 'z')))
                    return false;
            head ++;
            tail --;
        }

        return true;
    }
}
