package com.playgilround.schedule.client.dagger2.di

import com.playgilround.schedule.client.dagger2.MainActivity
import dagger.Component

/**
 * @Component: 컴포넌트는 @Inject 와 @Module 사이 다리이며 의존성 주입 역활
 * 컴포넌트는 미리 정의한 모든 타입의 인스턴스를 줌.
 *
 * @Component 어노테이션은 인터페이스에다만 달아야함.
 * 그리고 컴포넌트를 구성하는 모든 @Module 이 달린 클래스 목록을 적어야함.
 *
 * 컴포넌트에서 사용하는 모듈중 하나라도 없다면 컴파일 타임에 에러 발생.
 * 모든 컴포넌트들은 컴포넌트에 포함된 모듈을 통해 의전송의 범위 확인 가능.
 */

@Component(modules = [GithubUserListModule::class])
interface GithubUserListComponent {
    fun inject(Activity: MainActivity)
}