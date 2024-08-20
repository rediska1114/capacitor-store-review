/// <reference types="@capacitor/cli" />

declare module '@capacitor/cli' {
  export interface PluginsConfig {
    /**
     * These config values are available:
     */
    StoreReview: {
      /**
       * iTunes App ID.
       *
       * @example 1545567249
       */
      appId: string | number;
    };
  }
}

export interface StoreReviewPlugin {
  navigateToAppStore(): Promise<void>;
  requestReview(): Promise<void>;
}
