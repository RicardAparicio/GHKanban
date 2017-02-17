package inqbarna.com.ghkanban.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @author Ricard Aparicio <ricard.aparicio@inqbarna.com>
 * @version 1.0 02/11/16
 */

@Qualifier
@Retention(RetentionPolicy.SOURCE)
public @interface AppContext {}