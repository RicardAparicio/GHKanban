package inqbarna.com.ghkanban;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import inqbarna.com.ghkanban.config.AppContext;
import inqbarna.com.ghkanban.config.DataModule;
import inqbarna.com.ghkanban.config.NetModule;
import io.realm.Realm;

/**
 * @author Ricard Aparicio <ricard.aparicio@inqbarna.com>
 * @version 1.0 17/02/17
 */

public class App extends Application {

    private GlobalComponent mGlobalComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApp_GlobalComponent.Builder builder = DaggerApp_GlobalComponent.builder().appModule(new AppModule(this));
        mGlobalComponent = builder.build();
    }

    @Singleton
    @Component(modules = {AppModule.class, DataModule.class, NetModule.class})
    public interface GlobalComponent {

        @AppContext
        Context getContext();

        Realm getRealm();

        @Singleton
        NetService getNetService();

    }

    @Module
    public static class AppModule {
        private Context mAppContext;

        public AppModule(Application appContext) {
            mAppContext = appContext;
        }

        @Provides
        @AppContext
        Context provideAppContext() {
            return mAppContext;
        }
    }

    public static GlobalComponent globals(Context context) {
        return ((App) context.getApplicationContext()).mGlobalComponent;
    }
}
