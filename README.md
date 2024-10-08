# capacitor-store-review

Store Review capacitor plugin


# Available methods:

- `navigateToAppStore(): Promise<void>`
- `requestReview(): Promise<void>`

# Usage example:

0. In `capacitor.config.ts` (or `capacitor.config.json`)

```ts
plugins: {
  StoreReview: {
    appId: '1545567249'; // iTunes App ID.
  }
}
```

1. In your module (e.g. `app.module.ts`)

```ts
...
import { StoreReview } from 'capacitor-store-review'

@NgModule({
	...
	providers: [
		...
		StoreReview,
	],
})
export class AppModule {}

```

2. In your main component (e.g. `app.component.ts`)

```ts
...
import { StoreReview } from 'capacitor-store-review'

@Component()
export class AppComponent {
	constructor(private storeReview: StoreReview) {}

    someUserAction() {
        this.storeReview.requestReview()
    }
}

```

// TODO docs

## BREAKING CHANGES in 1.x.x version
 - Added support for Capacitor 5 and removed compatibility with Capacitor 3