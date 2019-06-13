package com.example.android.animalshelter.backbone;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public final class Completables {

    private Completables() {

    }

    public static Completable fromRunnableOnIo(final Runnable runnable) {
        return Completable.fromRunnable(runnable)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
