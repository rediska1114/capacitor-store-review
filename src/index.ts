import { registerPlugin } from '@capacitor/core';

import type { StoreReviewPlugin } from './definitions';

const CapacitorStoreReview = registerPlugin<StoreReviewPlugin>(
  'StoreReview',
  {},
);

export class StoreReview {
  navigateToAppStore = CapacitorStoreReview.navigateToAppStore;
  promtForRating = CapacitorStoreReview.promtForRating;
}

export * from './definitions';
