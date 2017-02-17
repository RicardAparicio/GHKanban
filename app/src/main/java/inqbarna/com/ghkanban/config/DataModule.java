package inqbarna.com.ghkanban.config;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * @author Ricard Aparicio <ricard.aparicio@inqbarna.com>
 * @version 1.0 17/02/17
 */

@Module
public class DataModule {
    public static final long   SCHEMA_VERSION = 1;
    public static final String GH_DB          = "gh_db";

    @Provides
    @Singleton
    RealmConfiguration provideRealmConfig(@AppContext Context context) {
        Realm.init(context);
        return new RealmConfiguration.Builder()
                .schemaVersion(SCHEMA_VERSION)
                .name(GH_DB)
                .deleteRealmIfMigrationNeeded()
                .build();
    }

    @Provides
    Realm provideRealm(RealmConfiguration configuration) {
        return Realm.getInstance(configuration);
    }
}
