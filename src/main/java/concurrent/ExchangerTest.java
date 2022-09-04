package concurrent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 */
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<String>();
//    private static final ExecutorService executorServicePool = new ThreadPoolExecutor();
    List<String > a = new ArrayList();
    List<String > b = new LinkedList<>();
}
