export interface StoreReviewPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
