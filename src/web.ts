import { WebPlugin } from '@capacitor/core';

import type { StoreReviewPlugin } from './definitions';

export class StoreReviewWeb extends WebPlugin implements StoreReviewPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
