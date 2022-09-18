
import java.util.*;
import java.io.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Consumer;


public class Main{
    public static void main(String[] args) throws IOException {
        System.out.println('c');
    }

    public class ShowMeBug {
        public void query(List<Airliner> airliners, Consumer<List<Integer>> callback){
            // 第1小题的实现
            Collections.sort(airliners, new Comparator<Airliner>() {
                @Override
                public int compare(Airliner o1, Airliner o2) {
                    try {
                        return o1.queryPrice().get()-o2.queryPrice().get();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            List<Integer> list = new ArrayList<>();
            for(Airliner air:airliners){
                try {
                    list.add(air.queryPrice().get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
            callback.accept(list);
        }

        public void queryWithLimit(List<Airliner> airliners, Consumer<List<Integer>> callback, int limit){
            // 第2小题的实现
            Collections.sort(airliners, new Comparator<Airliner>() {
                @Override
                public int compare(Airliner o1, Airliner o2) {
                    try {
                        return o1.queryPrice().get()-o2.queryPrice().get();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < limit ; i++){
                try {
                    list.add(airliners.get(i).queryPrice().get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
            callback.accept(list);
        }

        // 以下代码勿动
    }
}

