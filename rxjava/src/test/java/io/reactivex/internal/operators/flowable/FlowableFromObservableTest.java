/**
 * Copyright (c) 2016-present, RxJava Contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See
 * the License for the specific language governing permissions and limitations under the License.
 */

package io.reactivex.internal.operators.flowable;

import org.junit.Test;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.TestHelper;
import io.reactivex.exceptions.TestException;

public class FlowableFromObservableTest {
    @Test
    public void dispose() {
        TestHelper.checkDisposed(Observable.just(1).toFlowable(BackpressureStrategy.MISSING));
    }

    @Test
    public void error() {
        Observable.error(new TestException())
        .toFlowable(BackpressureStrategy.MISSING)
        .test()
        .assertFailure(TestException.class);
    }
}
