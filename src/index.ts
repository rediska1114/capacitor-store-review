import { registerPlugin } from '@capacitor/core';

import type { StoreReviewPlugin } from './definitions';

const CapacitorStoreReview = registerPlugin<StoreReviewPlugin>(
  'StoreReview',
  {},
);

export class StoreReview {
  navigateToAppStore = CapacitorStoreReview.navigateToAppStore;
  requestReview = CapacitorStoreReview.requestReview;

  /**
   * @deprecated Use `requestReview` instead.
   */
  promtForRating = CapacitorStoreReview.requestReview;
}

export * from './definitions';
