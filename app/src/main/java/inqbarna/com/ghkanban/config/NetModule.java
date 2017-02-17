package inqbarna.com.ghkanban.config;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import inqbarna.com.ghkanban.BuildConfig;
import inqbarna.com.ghkanban.NetService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * @author Ricard Aparicio <ricard.aparicio@inqbarna.com>
 * @version 1.0 17/02/17
 */

@Module
public class NetModule {
    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .client(new OkHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.from(Executors.newSingleThreadExecutor())))
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    NetService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(NetService.class);
    }
}
