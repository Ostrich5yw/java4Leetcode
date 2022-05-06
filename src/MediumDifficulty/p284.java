package MediumDifficulty;

import java.util.Iterator;

/**
 * @author 5yw
 * @date 2021/11/23 9:16
 */
public class p284 {
    class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> myIterator;
        Integer cache = null;
        /**
         * 当调用peek时，由于Iterator只有next和hasNext功能，即我们要知道下一个元素是什么，必须将指针移向下一位，
         * 然而peek希望只获取元素而不移动指针，所以用cache缓存next()元素
         * 即1,2,3  调用peek返回1,虽然Iterator已经指向2，但是当前元素 1 依然用cache保存，
         * 下次调用peek next hasNext时，优先判断cache是否为null
         * */
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            myIterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if(cache == null){
                cache = myIterator.next();
            }
            return cache;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if(cache == null){
                return myIterator.next();
            }
            Integer temp = cache;
            cache = null;
            return temp;
        }

        @Override
        public boolean hasNext() {
            if(cache == null){
                return myIterator.hasNext();
            }
            return true;
        }
    }
}
