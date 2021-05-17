package middle;

public class p137_GO {
//    func Do137(nums []int) int {
//        keymap := make(map[int]int)
//        for _, w := range nums {
//            val, bol := keymap[w]
//            if bol {
//                keymap[w] = val + 1
//                continue
//            }
//            keymap[w] = 1
//        }
//        for k, v := range keymap {
//            // fmt.Println(k, v)
//            if v == 1 {
//                return k
//            }
//        }
//        return 0
//    }

//    keymap := make(map[int]int)           //  最终结果等于[3*(a+b+c) - (a+a+a+b+b+b+c)] / 2
//    total := 0
//    fortotal := 0
//            for _, w := range nums {
//        total += w
//        _, mask := keymap[w]
//        if !mask {
//            keymap[w] = 1
//        }
//    }
//	for key := range keymap {
//        fortotal += key
//    }
//	return (fortotal*3 - total) / 2
}

