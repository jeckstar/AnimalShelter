package com.example.android.animalshelter.backbone;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
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

    public static <T1, T2> Completable fromSingleSources(
            SingleSource<? extends T1> source1, SingleSource<? extends T2> source2,
            Consumer2<? super T1, ? super T2> consumer
    ) {
        return Single.zip(source1, source2, (elem1, elem2) -> {
            consumer.accept(elem1, elem2);
            return 0;
        }).ignoreElement();
    }

}

