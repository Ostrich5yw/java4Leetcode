package MediumDifficulty;

public class p139_GO {

//    func checkWord(s string, wordDict []string) bool {
//        for _, tt := range wordDict {
//            if s == tt {
//                return true
//            }
//        }
//        return false
//    }
//    func Do139(s string, wordDict []string) bool {
//        var mark = make([]bool, len(s)+1)
//        mark[0] = true
//        for i := 1; i <= len(s); i++ {
//            for j := 0; j < i; j++ {
//                fmt.Println(j, i, s[j:i])
//                if mark[j] && checkWord(s[j:i], wordDict) {
//                    mark[i] = true
//                    break
//                }
//            }
//        }
//        return mark[len(s)]
//    }
}
